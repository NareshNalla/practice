package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Problem: Design Twitter (LeetCode 355)
 * Description: Design a simplified Twitter-like social network.
 * Supports posting tweets, getting news feed (10 most recent from self and followees),
 * following, and unfollowing users.
 */
public class DesignTwitter {

    // Global timestamp to ensure unique and chronological ordering of tweets
    private static int timestamp = 0;

    /**
     * Represents a single tweet with its ID and the time it was posted.
     */
    private static class Tweet {
        final int tweetId;
        final int timestamp;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    /**
     * Represents a user in the Twitter system.
     * Stores their own tweets and the set of users they follow.
     */
    private static class User {
        final int userId;
        // Stores tweets in reverse chronological order (most recent at head)
        final LinkedList<Tweet> tweets;
        // Stores user IDs of people this user follows
        final Set<Integer> followees;

        User(int userId) {
            this.userId = userId;
            this.tweets = new LinkedList<>();
            this.followees = new HashSet<>();
            // A user always follows themselves to include their own tweets in the feed
            follow(userId);
        }

        // Follows another user.
        void follow(int followeeId) {
            followees.add(followeeId);
        }

        // Unfollows another user.
        void unfollow(int followeeId) {
            // A user cannot unfollow themselves
            if (followeeId != userId) {
                followees.remove(followeeId);
            }
        }

        // Posts a new tweet.
        void postTweet(int tweetId) {
            tweets.addFirst(new Tweet(tweetId, timestamp++)); // Add to head for recency
        }
    }

    // Stores all users in the system, keyed by userId
    private final Map<Integer, User> users;

    /**
     * Constructor for the Twitter system.
     */
    public DesignTwitter() {
        // Pattern: Initialization | Time: O(1), Space: O(1)
        users = new HashMap<>();
    }
    // FAANG Tip: Use HashMap for O(1) average time user lookup.

    /**
     * Algorithm: Get or create user. Increment global timestamp. Create Tweet object and add to user's tweet list.
     *
     * @param userId The ID of the user posting the tweet.
     * @param tweetId The ID of the tweet.
     */
    public void postTweet(int userId, int tweetId) {
        // Pattern: HashMap Lookup & List Add | Time: O(1), Space: O(1)
        users.computeIfAbsent(userId, User::new).postTweet(tweetId); // Get/create user and post
    }
    // FAANG Tip: `computeIfAbsent` is a concise way to handle user creation if not exists.

    /**
     * Algorithm: Retrieve the 10 most recent tweets from the user and all followees.
     * Use a min-priority queue to merge tweets from multiple sources efficiently.
     * The PQ stores `Tweet`s, ordered by `timestamp` (oldest first).
     * Iterate through the user's own tweets and each followee's tweets, adding them to the PQ.
     * If PQ size exceeds 10, poll the oldest tweet.
     * Finally, extract tweet IDs from the PQ, sort them by timestamp descending, and return.
     *
     * @param userId The ID of the user requesting the news feed.
     * @return A list of the 10 most recent tweet IDs.
     */
    public List<Integer> getNewsFeed(int userId) {
        // Pattern: K-way Merge (Min-Heap) | Time: O(F * T_recent * log 10), Space: O(F * T_recent + 10)
        // F = number of followees + 1 (self), T_recent = number of recent tweets per user (e.g., 10)
        var user = users.get(userId);
        if (user == null) return new ArrayList<>(); // User not found

        // Min-heap to store tweets, ordered by timestamp (oldest first)
        // We want the 10 most recent, so we keep a min-heap of size 10.
        // If a new tweet is more recent than the oldest in the heap, it replaces it.
        var feedHeap = new PriorityQueue<Tweet>(Comparator.comparingInt(t -> t.timestamp));

        // Collect tweets from self and followees
        for (var followeeId : user.followees) {
            var followee = users.get(followeeId);
            if (followee == null) continue; // Followee might not exist

            // Add up to 10 most recent tweets from each followee
            // LinkedList.iterator() is efficient for iterating from head
            for (var tweet : followee.tweets) {
                feedHeap.offer(tweet); // Add tweet to heap
                if (feedHeap.size() > 10) feedHeap.poll(); // Maintain heap size to 10
            }
        }

        // Extract tweet IDs from the heap and sort them in reverse chronological order
        var newsFeed = new ArrayList<Integer>();
        while (!feedHeap.isEmpty()) newsFeed.add(feedHeap.poll().tweetId);
        Collections.reverse(newsFeed); // Sort from most recent to least recent
        return newsFeed;
    }
    // FAANG Tip: K-way merge with a min-heap is efficient for finding top K elements from multiple sorted lists.

    /**
     * Algorithm: Get or create follower and followee users. Add followeeId to follower's followees set.
     *
     * @param followerId The ID of the user who wants to follow.
     * @param followeeId The ID of the user to be followed.
     */
    public void follow(int followerId, int followeeId) {
        // Pattern: HashMap Lookup & HashSet Add | Time: O(1), Space: O(1)
        var follower = users.computeIfAbsent(followerId, User::new); // Get/create follower
        users.computeIfAbsent(followeeId, User::new); // Ensure followee exists
        follower.follow(followeeId); // Add to followees set
    }
    // FAANG Tip: Using `computeIfAbsent` simplifies user management.

    /**
     * Algorithm: Get follower user. Remove followeeId from follower's followees set.
     * A user cannot unfollow themselves.
     *
     * @param followerId The ID of the user who wants to unfollow.
     * @param followeeId The ID of the user to be unfollowed.
     */
    public void unfollow(int followerId, int followeeId) {
        // Pattern: HashMap Lookup & HashSet Remove | Time: O(1), Space: O(1)
        var follower = users.get(followerId);
        if (follower == null) return; // Follower not found
        follower.unfollow(followeeId); // Remove from followees set
    }
    // FAANG Tip: Handle edge cases like unfollowing self or non-existent users gracefully.

    public static void main(String[] args) {
        var twitter = new DesignTwitter();

        // Test Case 1: Basic functionality
        System.out.println("--- Test Case 1: Basic ---");
        twitter.postTweet(1, 5); // User 1 posts tweet 5
        System.out.println("User 1 posts tweet 5.");
        System.out.println("User 1 News Feed: " + twitter.getNewsFeed(1)); // Expected: [5]

        twitter.follow(1, 2); // User 1 follows User 2
        System.out.println("User 1 follows User 2.");
        twitter.postTweet(2, 6); // User 2 posts tweet 6
        System.out.println("User 2 posts tweet 6.");
        System.out.println("User 1 News Feed: " + twitter.getNewsFeed(1)); // Expected: [6, 5] (most recent first)

        twitter.unfollow(1, 2); // User 1 unfollows User 2
        System.out.println("User 1 unfollows User 2.");
        System.out.println("User 1 News Feed: " + twitter.getNewsFeed(1)); // Expected: [5]

        // Test Case 2: Multiple users, multiple tweets, 10-tweet limit
        System.out.println("\n--- Test Case 2: Multiple Users & Limit ---");
        var twitter2 = new DesignTwitter();
        twitter2.postTweet(1, 101);
        twitter2.postTweet(1, 102);
        twitter2.postTweet(2, 201);
        twitter2.postTweet(3, 301);
        twitter2.follow(1, 2);
        twitter2.follow(1, 3);

        twitter2.postTweet(1, 103);
        twitter2.postTweet(2, 202);
        twitter2.postTweet(3, 302);
        twitter2.postTweet(1, 104);
        twitter2.postTweet(2, 203);
        twitter2.postTweet(3, 303);

        twitter2.postTweet(1, 105);
        twitter2.postTweet(2, 204);
        twitter2.postTweet(3, 304);
        twitter2.postTweet(1, 106); // 10th tweet for user 1's feed
        twitter2.postTweet(2, 205); // 11th tweet for user 1's feed (oldest will be dropped)

        System.out.println("User 1 News Feed (expecting 10 tweets): " + twitter2.getNewsFeed(1));
        // Expected: [205, 106, 304, 204, 105, 303, 203, 104, 302, 202] (order might vary slightly based on exact timestamp of 101/201/301)

        // Test Case 3: User follows self (already handled in User constructor)
        System.out.println("\n--- Test Case 3: User follows self ---");
        var twitter3 = new DesignTwitter();
        twitter3.postTweet(1, 1);
        System.out.println("User 1 News Feed: " + twitter3.getNewsFeed(1)); // Expected: [1]
        twitter3.follow(1, 1); // Should have no effect
        System.out.println("User 1 News Feed after following self: " + twitter3.getNewsFeed(1)); // Expected: [1]

        // Test Case 4: Unfollow non-existent user or self
        System.out.println("\n--- Test Case 4: Unfollow edge cases ---");
        var twitter4 = new DesignTwitter();
        twitter4.postTweet(1, 10);
        twitter4.follow(1, 2);
        twitter4.postTweet(2, 20);
        System.out.println("User 1 News Feed: " + twitter4.getNewsFeed(1)); // Expected: [20, 10]
        twitter4.unfollow(1, 3); // Unfollow non-existent
        System.out.println("User 1 News Feed after unfollowing non-existent: " + twitter4.getNewsFeed(1)); // Expected: [20, 10]
        twitter4.unfollow(1, 1); // Unfollow self (should not happen)
        System.out.println("User 1 News Feed after unfollowing self: " + twitter4.getNewsFeed(1)); // Expected: [20, 10]
    }
}

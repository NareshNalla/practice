frontend:
AngularJS: We define a base path and assign a HTML for it now we define routes for the base path and we have controllers for various UI elements.
so instead of getting entire web page only that part is fetched by controller.we can also direclty give like show this view if this is set as true 
which means there is a direct binding between view and data. To communicate between controllers we have to define services


johnsons algorithm:all simple cycles in graph
stack, blocked set, blocked map
for simple cycles except the starting point of loop every other must be visited only once.so restrict visiting same node twice in current stack
for each vertex start from that and dfs for all connected vertex recursively. as you go on add them to stack and to blocked set.
https://www.youtube.com/watch?v=johyrWospv0&t=393s
here we didnt visit 2 from 5 but 2 is connected to 5 so there might be a cycle from 5 though 2 so add 2->5 to blockmap.
here we came to 2 second time so a cycle is formed and now when we unblock 2 we will unblock 5 and so on might be we will unblock every vertex
so time complexit is for every cycle we can have o(e+v) editings considering cycles as starting and ending at same vertex also time complexity = o(e+v)(c+1)  

clone linkedlist with random pointers in o(n) time and o(1) space
https://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/

linkedlist can be converted to doubly linkedlist using xor linkedlist
node.next = xor(node.previous,node.nextnode)
https://stackoverflow.com/questions/16138998/how-exactly-does-a-xor-linked-list-work
find pair with given sum in sorted linkedlist in o(n) time and o(1) space

pair with given sum balanced bst => o(n) time o(logn) space
over internet communication can only be done between 2 machines with public ip so my laptop talks to router which is internet facing and 
this talks with other ip on my behalf and directs packets to me. so basically router stores which ip requested what and stores in NAT table
NAT tables are present everywhere where multiple networks come into scene
This is the reason only we have 172 and 10 and 192 in the local networks so that other ips are made to public


o(n) and o(k)
http://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/

virtual machines:
type 1 hypervisor ==> directly loaded onto hardware used in servers generally
type 2 hypervisor ==> loaded onto existing os. used in laptops etc.. for personal use

SubnetMasking:
255.255.255.255
255 means 11111111 in binary. so 255.255.255.255 has 32 1s 
so 172.16.250.0/24. 24 means thare are 24 1s fixed meaning last 8 s are remaining for allocation of ips and 0 are assigned 
to last allocatable ips.
172.31.0.0/16
here since 16 are allocatable 2 0s in sequence
for this subnet is 255.255.0.0 which is 172.31.0.0&&255.255.255.255
so subnet is just an ip range and these range are in same network
different subnets are connected with routers

e  a  d
 b   c
   f
lets say a b c fare routers connecting different subnets and connecting in form of square. a and b are connected to gateway e and a and c to f
if request to a dont have route to destination ip means dont have entry in its route table then it asks the gateways e and d.now they also dont know
adress so they ask everyone connected to them so a might again get request and since it is from request from gateways send it to the remaining connected routers and so on
finally f tells to b and b tells to a and a tells to c. both and c updates route tables if destination is f then route it to node which gave me response in low time
swithces also maintain route table
so gateway maintains entire destinations.swithces and hubs manage traffic within a subnet so as to decrease load to router. if no switch for every new destination router has to pass this info
to below nodes. now it knows only fron source = swithc and destination=unknown

internet gateway is gateway which connects internet.
Computers that are on the same /24 know how to talk to each other. Computers that are not need to be told, which is what routes are for. Since both of these address ranges are private, this even more important, because there is no magical 0.0.0.0 route to point out to the internet.
means   172/24subnet--router-192-router--172/24. here if 172.17.3.1 exists in both subnets then it is routed to the machine in same network because ip ranges are same


www.quora.com first request goes to root server for dns. it says go to com server which redirects to quora domain server within its cluster
which redirects to www server in it so you get ip from there

uWSGI:
Nginx can only handle static content but for dynamic content we need something like guincorn or uwsgi
workers: normal workers which gets blocked for blocking calls
processes: workers with support for async mode as in nginx threads unless given async flag behave as workers
uwsgi is protocol like http and uWSGI is server which accepts uwsgi by default but can be configured to accept http
uwsgi is faster than http so we use nginx to convert http to uwsgi and route it to uWSGI
coming to cache uWSGI stores cache for objects of requests it received so basically for uwsgi objects.so instead of caching at uwsgi we cache at nginx level which removes the overhead
of converting http to uwsgi for repeated requests
nginx caching has many options like fetch content from webserver and update cache every x minutes or restrict caching for some requests.
if 2 non blocking tasks one with long time and other with short running time are done then the one they execute sequentially in the order of their occurence even in async mode
 meaning task switching only happens when blocking call occurs

docker entrypoint is different from cmd we can override cmd using args but not entrypoint
docker run demo ls
docker attach nameofthecontainer
docker run --name=jjj ubuntu
docker bridge network: bridge network valid only in localhost
docker overlay network: network that can be spanned across multiple hosts. can be used for docker swarm\
external_links links containers outside docker-compose or docker host
external_hosts can create mappings to ips to hostnames
all the services in docker-compose will be automatically added to hostnames of all containers present
docker VOLUME command is used so that docker creates this folder in /var/lib/docker/aufs/volume diretory and thus we can use this volume in other containers or persistent over container updates
here ls replaces the CMD command
only one cmd statement allowed after CMD execcution stops

if you keep long running operation in RUN mode then the image dont build 
ENTRYPOINT ["/bin/ping","-c","3"]
CMD ["localhost"]
runs the command /bin/ping -c 3 localhost
only later cmd operations will get executed
entrypoint is just entrypoint meaning every cmd or exec command executes the statement with entrypoint executable
cmd ifconfig throws error without entrypoint

so priority order is entrypoint,arg from docker run command and then CMD
docker exec executes the command inside the container and brings output to terminal if attached

socket programming is different from rest api. rest apis are stateless and give data when requested basically clients have to poll
and pull data whereas in socket programming a persistent connections is made and basically server pushes data to registered clients when there is new data or datachange
websites can use socket connections also basically a persistent connection exists always till closed.problem is only a limited number of connections can exist per server. videos use socket programming because data is frequently changed.Also used in GPS sending
ENTRYPOINT ["python"]
CMD ["app.py"]
entrypoint comes like this
ENTRYPOINT["mongo"]
now docker exec -it 

rain trapping problem:
stacks are useful when you want to have only some comaprisions like find the before longest element for every element or like waterfall problem or comparisions based on quantity like queen or politician problem
find max till now traversing from left to right and right to left and you will have tallest bar in right side and left sides and height of water above this column = min(obtained heights)-height of this tower
http://www.geeksforgeeks.org/trapping-rain-water/
https://www.hackerearth.com/challenge/hiring/lenskart-java-developer-hiring-challenge/algorithm/thief-and-warehouses-6ebf4e07/
http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/
https://www.hackerearth.com/challenge/hiring/lenskart-java-developer-hiring-challenge/algorithm/increasing-subsequence-fbb63e3c/
similar problem with o(n) and o(nlogn) solutions

int findWater(int arr[], int n)
{
    // initialize output
    int result = 0;
     
    // maximum element on left and right
    int left_max = 0, right_max = 0;
     
    // indices to traverse the array
    int lo = 0, hi = n-1;
     
    while(lo <= hi) 
    {
        if(arr[lo] < arr[hi])
        {
            if(arr[lo] > left_max)
            // update max in left
            left_max = arr[lo];
            else
            // water on curr element = max - curr
            result += left_max - arr[lo];
            lo++;
        }
        else
        {
            if(arr[hi] > right_max)
            // update right maximum
            right_max = arr[hi];
            else
            result += right_max - arr[hi];
            hi--;
        }
    }
     
    return result;
}

here we are maintaining min(left max and right max)..see for inspiration

sometimes you do sametraversal in opposite order eg:longest bitionic sequence

given a large box and small boxes to fill that volume generate subsets with total volume < largebox and for each subset insert boxes with top volume first
Hashmaps are way slower than arraylists because hashmaps have to maintain the hashvalue when more collisions occur so in process copies entire hashmap. so use arrays always try
if you cannot optimize solution in given memory then see if increasing time complexity helps if less than time limit
Maximum size square sub-matrix with all 1s

sockets: any communication must go through sockets be it http or udp etc...for interprocesscommunication .sock files are there where in one process reads ant the other writes data

lcm = product/gcd
ll gcd(ll x,ll y)
{
	if(y==0)return x;
	else return gcd(y,x%y);
}

You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. It is also allowable to use multiple instances of the same type of box.
make all the possible rotations of boxes to get different base areas and sort the array based on base areas and do lis for longest decteasing base areas and selecting height if base areas equal

given a and b and n find number of distint elements in set formed by multiples of a or b less than equal to n = n/a + n/b - n/lcm(a,b)
http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
LIS o(n2) method

sticky session means once a session is established until the session ends load balancer will route to same machine
session management facebook
put vs delete vs post vs get ....

http cookies
to eliminate single point of failure you have to create a cluster for load balancers also
oauth
oauth or https or ssh can be hijacked by knowing shared key
cpu is always faster than io or internet etc... so cpu fastly performs processses in queue and each queue accumulates before cpu reaches them again

fragmentation
when a process finishes its memory in ram is released thus fragmentation occurs and to allocate new process to that area. os needs to unite all free spaces at one point and send a program into thus created space.page table is how os keeps track of memory addresses freed and also to calculate the size of new process that is going to enter a unit pageunit is taken and all memory is based on the number of units of pageunit
64 bit means the length is 64 meaning in terms of virtual memory everything is 64 bit
cors ==> cross origin resource sharing means other domains can access resource files like css etc... from this domain
pyjwt and other encryptions
os pages , process of reading from disk
say a page = 1kb and we have a process of 3 kb then cpu allocates 3 pages availabe to it which need not be in same place and keep track of what pages are allocated to PID so that swapping other processes with this easy when required
SSL certificates are used for http ==> secure socket layer
pyjwt uses hmac algorithm
mongo mapreduce aggregations

dynamodb provides single set of inserts etc... and under the hood aws takes care at database engine part
aws cloud formation is jsons with config info of aws resources so infrastructure can be created on fly. this json can also be genrated with gui elements
elastic bean stalk is like heroku where we give all necessary info and allow to automatically scale

elastic cache is cache engine with popular options like redis

security is generally done by passwords restricting port access outside access TLS certificates. for instance docker swarm can be protecte by TLS certificates and a seperate TLS cetificate server must run for this

proxy server caches data , has public ip and fetches data from internet and routes it to host on local network , blocks websites......
vpn encrypts data and also you can access banned content

(ab) mod p = ( (a mod p) (b mod p) ) mod p 

external mergesort:
small chunks are first merged using mergesort. now since all chunks dont fit in memory merge happens on file and for consequent merges contents are read from and to file
incase of joins database can either go on with nested join means for every record in outer table every record in innter table is compared. Hash join means hash table is creaed for small table and for every record in outertable hash table is traversed to get relevant records.also external mergesort is used where sorting occurs based on the join key and records are compared based on that.

hashtable is synchronized. hashmap is not. concurrenthashmap is synchronized.
data is made into parts to send in form of packets
tcp handshake:
client asks server with syn to connect
server sends the same syn and an ack to client
client again sends this ack and connection establishes

try to minimize stroing arrays in db. if stored solve the problems of duplication and updating if one of the array element changes all elements linked with that should be changed accordingly

dynamic programming:
LIS subsequence 
if you think the subsequence depends on only last element value then LCS if it depends on all previous elements then LIS
Longest common substring subsequence
LIS with highest sum

LCS 3 arrays ==> o(n3)
Longest Increasing subsequence ==> o(n2)
have an array and find the longest common subsequence at every point and finally you will have the answer
eg:

tcp can recover data.

udp order of receiving is not garanteed

in kmp algorithm we start matching string from unmatched position for every mismatch we move substring by 1 so for 
every mismatch let o(x) then for comparing entire string o(x) so in total o(2x) see online animation for more clarity

3 Bulbs and 3 Switches ==> turn on switch 1 for 10 min and turn off and turn on switch 2 now bulbs will be one on , one hot and one cold

search for each word whether there is or not that word in grid
http://www.geeksforgeeks.org/boggle-set-2-using-trie/

hub ==> receives data from source host and sends it to every other member of host
switch ==> stores the source ip when received data and in future if it finds the destination ip in this table routes only to that machine else works like hub
router ==> dhcp , sits between different networks
router can also be used like swithces and hubs but consider cost
DHCP ==> dynamic host configuration protocol
dhcp constantly checks all hosts to remove unused ips
when client asks dhcp server for ip(basically pings all connected machines and dhcp server responds) it offers it and the client says it has received and dhcp notes it down
in case of 2 dhcp servers single of them has some set of ips distributed
to have multiple dhcps on same network split range of ips between them
tcp sends packets and receives acknowledgemnet. if ack is not received resends data

http stateless
to make it stateful use sessions and cookies
cookies are always client side and they store the key to map a request to whom it is making
session is just data can be client side or server side.
url rewriting, hidden fields (HTML form)
put vs delete vs get vs post
fuzzy search
see adress bar of youtube.con
there can be multiple load balancers for same machines for the sake of failover
ha proxy frequently performs health checks on servers 
to implement load balancing based on ram your application must return http 404 on health check if ram exceeds and in haproxy config you can use parameters from http-chk module to route your request

see that in case of threats there can be multiple people in returning step from the other side
http://www.geeksforgeeks.org/puzzle-river-crossing/
for more clarity see
http://www.geeksforgeeks.org/puzzle-farmer-goat-wolf-cabbage/

genrealizing security and certificates in ssh and https
ssh also works as https public private and shared key
in ssh there must be another key which represents some system. shared key can represent different sessions
so for the first time client asks public key. server will have rules to allow ssh connections from these users or with these credentials or based on ip.. now the server sends public key and  the client validates the certificate with registered certificate sources and if not in sources shows unsage https connection. browser checks if certificate is for this url to send a shared key and then authentication is done over this connection with shared key itself 
after getting shared key it is used for future transactions for locking and unlicking

how shared key is created:
both parties decides algorithm and some key
party1 ==> generates its own private key randomly and generates the public key using algorithm,shared key and its private key and shares this with party2
party2 ==> does the same as party 1
now decryption always happens with private key and encryption only happens with public key
now to check again the data is sent safely md5 hash values are generated after each transaction using shared key and data sent. receiver generates this hash and sent to sender and sender rechecks the md5 data and validates.
so creating shared key is assymetic encryption(decrypting and encrypting keys differ) and once shared key is generated symmetric cryptography is used
assymetic encryption involves more computation than symmetric encryption
to a client encrypts credentials with public key which can be dec

SSL:
uses sha-256 encryption
3 kinds of ssl certificates
1) verifies you are the right owner of domain see adress bar of youtube.con
2) verifies you are the one who you says if you say you are the bank the verification that you are the bank see adress bar of bankofamerica.con ==> large green bar
3)self signed certificate
HTTPS ==> 443
HTTPS ==> staetful  ==> because of shared key
server has private key when browser asks to connect server sends its certificates to browser and every browser has a set of sources of https certificate providers and checks the received
certificate agains that if ok it gets public key from certificate and and creates shared key and sent to server. this data can only be accessible when we have private key so servers decrypt the data to get shared
key since it have the private key. from now on until the session finishes this shared key is used. server cant have 2 shared keys same at a time.client can decode data since it has shared key. 


SSL secure socket layer
SSL certificate encrypts data https
http is unencrypted 

browsers inspect html forms to see which might go into login credentials and based on that asks us to store password in browser

when we use join rather than subqueries the database engine creates an execution plan to get which records first etc.......


for each network drive we create an IP gets associated by DHCP and this is communicated to other locations

abstract classes can be instantiated


General recommendations might be the following: if the load pattern is CPU intensive—for instance, handling a lot of TCP/IP, doing SSL, or compression—the number of nginx workers should match the number of CPU cores; if the load is mostly disk I/O bound—for instance, serving different sets of content from storage, or heavy proxying—the number of workers might be one and a half to two times the number of cores. Some engineers choose the number of workers based on the number of individual storage units instead, though efficiency of this approach depends on the type and configuration of disk storage.


docker swarm:
swarm is used when you have to deply high number of docker container for each application
discovery servicec ==> consul or zoo keeper
manager docker
docker swarm assigns tags to set of nodes and when a new container is created we can run it on a tagged area with that image pulled locally or resources like cpu ram or port free based on scheduling we give 
docker election for managers:
min 2 managers required for point of failure
say there are 3 managers and one of them is leader. each follower run a timer withinwhich it should receive heartbeat of manager. manager sends heartbeat and followers reset timer and sends their heart beat. the timer time is randomly chosen. if timeour has happened follower enter candidate mode and vote itself and ask other nodes to vote it and other nodes vote that. in case of 2 candidates become leader at same time both of them enter canddate mode again and the loop go on also since now all candidates nodes which havent asked votes till now can timeout and become new leader
a node can be both manager and worker nodes
manager takes care of load balancing , heartbeat from workers , worker failovers etc...
leader takes care of collecting heartbeats of managers , cluster management


celebrity problem
 N people are there.
         knows(A,B) return true if A knows B, else false.
         Celebrity: A is called a celebrity
                 If A knows none
                 Everyone knows A
Get celebrity, with less number of knows() method usage.
push people one by one onto stack by comparing whether a person can be celebrity or not. finally only one person remains in stack and compare him with all others if there is a celebrity at all
use this algo when there is multi relation as above

snake and ladder problem ==> reach 100th cell from 1st when you have control over dice outcome ==> shortest path problem ==> djikistra

djikistra dont work for negative edges think why
even biasing negatives also dont work because djikistra basically disable you to revist a vertex but if negative edges are there you have to vist most negative edges with min sum adding so a vertex is visited multiple times
also adding less sum is different from removing already available sum
so bellman ford algorithm
bellman ford algorithm keep track of previous vertices so that you know the shortest path
iterate min(v-1 times or till updating stops) and update distances if on v th time also the distances change negative cycle detected. basically at most a node distance can be changed by other n nodes and at 
worst only one node can affect a node distance hence n iterations

find shortest path in reaching from start to end bellman or djikistra

in prims algorithm dont consider edges starting and ending with same vertex.if ab is selected first next take minimum of edges starting from a and b . now i selected bc take min of edges starting from c and the edges
we added before and so on...... be careful about when multiple connected sets are there o(E+vlogv)


For Prim's algorithm, the graph has to be connected, but that is not true in the case of Kruskal's algorithm.
Prim's algorithm is found to run faster in dense graphs with more number of edges than vertices, whereas Kruskal's algorithm is found to run faster in sparse graphs.

in kruskals algo we sort the edges and consider each vertex as a disjoint set now for each edge we keep on for ex ab we join disjoint sets
of a and b into one if a and b are in different disjoint sets if there is an edge which bascially connects two vertices in same group then we neglect since cycle is formed
this algo is also used for detecting cycles
https://www.youtube.com/watch?v=fAuF0EuZVCk&t=444s


kruskals and prims algo support negative edges
kruskals ==> o(eloge+e)==>o(sorting+unionfind)
prims ==> o(e+elogv)

find a min path that connects every vertex in a graph means mst. find min path connecting given vertices is mst with given vertices

prims algo proof:
in mst we need every vertex so we have to choose min branch at each vertex
a cycle forms if we connect two visited nodes but it dont happen in prims algo as every time we only take vertex with smallest
distance from unvisited nodes

for union find algorithm path compression 
by always trying to combine equal sizes we have 2(n/2 + n/4 + ....)< 2n
for practical values of union find path compression takes o(<=5n)

strongly connected components ==> kosaraju algorithm o(n) ==> https://www.youtube.com/watch?v=RpgcYiky7uw
time table graphs havind dependencies
strongly connected problems
prims algorithm and kruskal algorithm

Suppose that you have two sets of people of cardinalities m,n and you want to divide them into teams of k people with every team being composed of people of only one of the original two sets. Then the maximum value of k where this is possible is gcd(m,n)gcd(m,n).

strongly connected components ==> facebook might use to find strongly connected people to find common interets ==> kosaraju alogrith based on topological sort

detect if there is a cycle in the graph ==> color coding method
find all simple cycles in a graph ==> https://www.youtube.com/watch?v=johyrWospv0

Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
later

priority queue insertion one by one element is o(nlogn)
priority queue creating from given elements is o(n)
https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity


skyline problem
http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
divide and conquer is used when every element is to be compared against every other element

construct a BST given preorder ==> 
take first element
 if next element leis in left subtree:
   ++index
   constructleft subtree
   go for right tree
 else if next element in right subtree:
   ++index
   construct
 else:
 	pass 

There is a building of 100 floors. If an egg drops from the Nth floor or above it will
break. If it’s dropped from any floor below, it will not break. You’re given 2 eggs. Find
N, while minimizing the number of drops for the worst case.

egg drop problem
https://www.youtube.com/watch?v=o_AJ3VWQMzA

hat riddle 
https://www.youtube.com/watch?v=N5vJSNXPEwA

cross the bridge in min time and only one lantern with 2 people on bridge. take 2 fastest people to other side first and make sure the slowest poeple go together

building btree from given traversals needs you to pass the index ranges to the function

given a string find if it has duplicates use only arrays. time complexity o(n) ==> auxiliary array
instead of auxilary array since we have 256 characters and each int is 32 we maintain 8 integers and each bit responds to a character toggle the bit to 0 or 1. 


You are trying to cook an egg for exactly fifteen minutes, but instead of a timer, you are given
two ropes which burn for exactly 1 hour each. The ropes, however, are of uneven densities meaning you dont know whether it takes halfan hour to burn first half like that....

Start burning the 1st rope from both end and 2nd rope from one end 
When first rope finished burning (which take exactly 30 minutes to burn from both end) torch the other end of 2nd rope to burn, which takes exactly 15 minutes to burn

Add arithmetic operators (plus, minus, times, divide) to make the following expres-
sion true: 3 1 3 6 = 8


There is an 8x8 chess board in which two diagonally opposite corners have been cut
off. You are given 31 dominos, and a single domino can cover exactly two squares.
Can you use the 31 dominos to cover the entire board?

Impossible. Here’s why: The chess board initially has 32 black and 32 white squares. By re-
moving opposite corners (which must be the same color), we’re left with 30 of one color and
32 of the other color. Let’s say, for the sake of argument, that we have 30 black and 32 white
squares.
When we lay down each domino, we’re taking up one white and one black square. Therefore,
31 dominos will take up 31 white squares and 31 black squares exactly. On this board, how-
ever, we must have 30 black squares and 32 white squares. Hence, it is impossible.

sparse index:
if you are creating unique index on a filed and that field is missing in some documents one option is to add the field with value null but here unique property is sacrificed so create sparse index which creates 
	index only to available documents with the given field
unique index ensures duplicate values are not allowed only that is the use
to index arrays mongo uses multikey indexing
here individual array items are keys of bst and each key has the document ids associated with them in array
multi index is not supported if the compound index have fields with more than one array type. imagine you insert new record with compund index on 2 array fields each having 30 elements means mongo has to update
900 indexes in total disastrous
mongodb also supports partial indexes which are obtained by a given filter
full text index is there in sql and it is used to search for text inside fields
sparse index in sql if we have n records and we fix block size as 2 then we have n/2 blocks and we traverse through theses blocks where each block is indexed based on the first record in it.now search inside 
the block one by one to find the required row. this is also called block index
however mongodb sparse index does not maintain blocks but it is just index on documents with given fields present
A reverse key index reverses the key value before entering it in the index. E.g., the value 24538 becomes 83542 in the index. Reversing the key value is particularly useful for indexing data such as sequence numbers, where new key values monotonically increase.
bitmap index is used when cardinality is low for compound bit index with 2 fields 2 bits are taken into account
in bit index for instane take gender a 2*2 matrix is formed with columns as rowid and rows as male femals and for each row cell if the rowid has male then the male cell is set to 1 similrly for female cell
now where gender=male can be attained directly by seeing this matrix.if caridinalty is 40 means if index is binary then ln 40 if bit index extraspace in ram is 40 bits*objectids. so see memory consumption before
going with bitindex

first normal form:
each cell must contain single values arrays not supported.
each row must have unique indetifier and each column must have same type of number
nosql databases override this form

second normal form:
every table must be broken to atomic units
if a field dont depend on primary key see moving it reduces data reduncdancy
for example price of xbox dont change with trnsaction id and now instead of having cost for every document we have seperate collection with device and price and when price updates we directly update this collection
and this also reduces data we have to store

third normal form:
every non prime attribute must dependent on a prime attribute and not on other non prime attribute. two prime attributes are not allowed
no two rows are identical

fourth normal form:
dont duplicate rows for adding one extra column

if you follow above rules to seperate completely then different queries have to be done for different data if you dont one time reading large data is not recommended so dont overoptimize your collections
always decouple database querying from application

desigingin database is all about decoupling data and seeing how use decoupling is


You have a five quart jug and a three quart jug, and an unlimited supply of water
(but no measuring cups). How would you come up with exactly four quarts of water?

detect a loop in a linked list without extra space
https://www.youtube.com/watch?v=apIw0Opq5nk
Distance traveled by fast pointer = 2 * (Distance traveled 
                                         by slow pointer)

(m + n*x + k) = 2*(m + n*y + k)

Note that before meeting the point shown above, fast
was moving at twice speed.

x -->  Number of complete cyclic rounds made by 
       fast pointer before they meet first time

y -->  Number of complete cyclic rounds made by 
       slow pointer before they meet first time

From above equation, we can conclude below

    m + k = (x-2y)*n

Let slow made q rounds and fast made p rounds initial offset is x and s is ahead of fast and final offset of meeting is y ahead of starting
so x < n y < n and p = 2q+((y-2x)/n) max value of 2n and min is 0 so p < 4n and q < n 

build lowest number by removing k digits 
http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
o(n) and o(1)

database keep in mind:
avoid duplicacy of data 
check if the operations are read intensive or write intensive in mongo can use replica set for this purpose with master and slave different database engines
if storing in arrays check the maximum size of array and if querying goes well with indexes
handling all dependencies if you are deleting an object id


Let first input string be”test string” and the string which has characters to be removed from first string be “mask”
make an array of length 27 and have count of each element of second string and traverse through string 1
see if you want to keep track of elements or even the order is needed if first is correct go with count array else go for sorting

Tarzan algorithm ==> topological and strongly connected components
johnsons algorithm , all pair shortst algo using johnson
code kruskal algo and prim algo
https://www.youtube.com/watch?annotation_id=annotation_2645813813&feature=iv&index=2&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&src_vid=fAuF0EuZVCk&v=oP2-8ysT3QQ


maximum sum sub-matrix
http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/

find majoirty element means find element which occurs more than n/2 times in the array o(n) and o(1) ==> voting algorithm
http://www.geeksforgeeks.org/majority-element/
if we cancel out the unequal elements the one element which remains till end has the chance of majoirty element so check whether or not it is majoirty element
findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]
A[] = 2, 2, 3, 5, 2, 2, 6
Initialize:
maj_index = 0, count = 1 –> candidate ‘2?
2, 2, 3, 5, 2, 2, 6

Same as a[maj_index] => count = 2
2, 2, 3, 5, 2, 2, 6

Different from a[maj_index] => count = 1
2, 2, 3, 5, 2, 2, 6

Different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
2, 2, 3, 5, 2, 2, 6

Different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 2 => maj_index = 4
2, 2, 3, 5, 2, 2, 6

Same as a[maj_index] => count = 2
2, 2, 3, 5, 2, 2, 6

Different from a[maj_index] => count = 1

Finally candidate for majority element is 2.


find all the disitnct anagrams of String S, sort them lexicographically and then print to output the anagram that occurs at the Nth position in this sorted order.
given a string find its rank in o(n)
https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
for bot above problems if the string is aabc create count for each elemnt and calculate max rank of string with a in first place and then b and so on

a ring with n vertices and a bead takes k steps at a time when does bead visits already visited vertex.
for every time bead crosses its initial position it accumulates a remainder if this remainder equals k then the node gets revisited
so the first node being revisited will be the vertex of start position since remainder change happens just before
to reach initial position we need LCM(n,k)/n steps 

number of trailing zeroes in factorial
http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/

Given an array of integers and N operations in the form of (i,j,k), which means add k to all the element from i to j in the array, and print the array after N such operations.(Use Segement tree)
segment tree

reverse string without for loop
 static String reverseMe(String s) {
   if(s.length() == 0)
     return "";
   return s.charAt(s.length() - 1) + reverseMe(s.substring(0,s.length()-1));
 }

reverse array without using - operator ==> use stack

https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

competitive coding:
try to do a single global function for all test cases if number of test cases are large

http://www.techiedelight.com/change-elements-row-column-j-matrix-0-cell-j-value-0/
while reading if we read each row as integers then we can actually output an array of integers which when converted to binary counter parts solution is obtained

to verify a number is prime or not check for(int i = 1;i*i < number;i++){}
mark composite numbers
we came to i means we have marked all composites that can be formed by (0,i-1).so i*(i-1) is marked so j starts from i*i
lets think some composite exists with no factor below i where i*i>=limit. so let the prime be i+k so that (i+k)*something = composite and <=limit.also we have checked for all i (0,i) so something>i 
but i*i >= limit which contradicts so something<i if so we have covered since we are going from (0,i)

void sieve()
{
    for(int i=2;i*i<=100005;i++)
    {
        if(prime[i]==0)
        {
            for(int j=i*i;j<=100005;j+=i)
                prime[j] = 1;
        }
    }
}

Given an array which contains value in range 0 to N^2. sort it in order of N time complexity.
take sqrt of numbers wihich lies between 0 to N now get numbers which square root are 1 and two and so on 

given a number, and an encoding technique like 1-> A, 2-> C…. 26->Z, How may different valid encryption can be done. Like 123 can be decoded as ABC or LC or AW. so the count is 3
use dynamic programming http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/

towers of hanoi:
for forming t(n)=2*t(n-1)+1 meaning to form t(n) we have to count 2*t(n-1) which means count 4*t(n-2) form this like tree
        recursion             constant
         n                     0
    n-1     n-1                1   
  n-2 n-2 n-2 n-2              2*1

in above tree to get n we find sum of just below branch and recursive thus n = number of nodes in last branch = 2^(n-1)
we leftout constant factor which sums to 2^(n-1)-1 so total complexity is 2^n -1

max reach problem
http://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

latttt:
http://www.geeksforgeeks.org/find-number-of-islands/
url shortening
meeting scheduling problem
AVL treees
nodes of distance k
network and packet routing
mutex sempaphore deadlock
when to use no sql and sql
normalization
R Tree and spatial data indexing
elastic search indexing for retreival of words from text
Longest Bitonic Subsequence vs LIS
https://www.youtube.com/watch?v=TWHytKnOPaQ
given o(n2) apply LIS o(nlogn) to get it that way
http://www.geeksforgeeks.org/largest-rectangular-sub-matrix-whose-sum-0/
branch and bound method for knapsack and 15 number puzzle
http://www.geeksforgeeks.org/branch-bound-set-4-job-assignment-problem/

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively
here there are only 2 possibilities whether or not include a weight. if can be included v(n)+arr[n-1][w-weight[n]] else arr[n-1][w] max of these 2 values.
this shows that we can use dp anywhere if we got a condition

longest common palindrominc subsequence ==> LCS for string and reverse of it

nosql databases:
if you have array in one of the fields then nosql is for you. If you want highly optimized setup sql is for you but sql always have data reduncdancy
dont add null values for sake of having a field and similaryly boolean values
nosql could support nested fields
what makes hadoop highly scalable than its contemporary technologies
hadoop vs cassandra

bruteforce all possible moves and stop if you arrive at already seen position till now
http://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/

angular js:
cache factory
functions ==> services

mutex is lock and and semaphore is number of copies of the keys can be created to unlock the lock 

The fundamental difference is wait() is from Object and sleep() is static method of Thread . The major difference is that wait() releases the lock while sleep() doesn't releas any lock while waiting

standard knapsack problems     segment treees with lazy propagation

import java.nio.ByteOrder;





pract
maximum submatrix sum and ones








JENKINS:
Continuos Integration: automatically build our repositories when some change is done. auto running unit tests. compiling our main repository
whenver whenver one of the dependency repository changes. auto deploy to dev server if needed
jenkins mostly have plugins to do everything so make use of them even for unittests of python

if you have an order of projects to build then use trigger join
see locks and latches also
reporting plugins

artifact deployer
deployment plugins

vpc vs availablility zones vs region vs subnets

CI:
testing  unittests and integration testing with same environement as deployment
build    build all files necessary for our application
release  setup environement that is equal to deploy environement
deploy   deploy

jenkins manages everything terraform or puppet etc.. manages
infrastructure and deployments. if your infrastructure is in form
of python code then you can do everything with jenkins
ansible or terraform provide just code and even to trigger that build process we need jenkins

kubernetes:
kubernetes runs on any platform not necessarily GCP
kubernetes and swarm support 50000 containers beyond that move to mesos which is difficult to setup and dont work well if container count is low
kubernetes has manager and nodes. 

manager has api endpoint, scheduler which schedules jobs ,key value store storing where a container is deployed etc..controller basically controls all other things like what happens when 
a machine goes down etc......

node has kubelet which relays which dockers are there in node, registers this node , reports back to manager if some docker goes down take tasks from manager have endpoints for docker containers present
thier health etc.. in current node.

service for instance you have 2 haproxy dockers then bot of them act as single ha proxy
using services see docker-compose scale.kube proxy manages this network interactions
you can give tags for service and it load balances only those pods which have all the tags of service doesnt matter if there are extra tags for pods

containers are deployed inside pods and pods are deployed onto cluster.pods can also
 have multiple containers

we scale pods and multicontainer pods are used when you have to have tight coupling between 2 applications
a pod creates a network stack and memory which are shared among its containers with each container has its own ip provided by docker

controlling kubernetes where new pod goes cross data center issues,region issues,based on ram etc..
minikube



AWS:

VPC(virtual private cloud): like local network for your set of instances
2 vpcs can be connected and security rules can be imposed. with vpc you have security
we can take dedicated hardware

VPC have subnets,route tables , internet gateways , elastic ips , endpoints(transferring traffic locally to s3 or other aws services),
nat tables , peering connections, VPN , security groups and network access controls

each region has multiple availablility zones which are like seperate datacenters
VPC is region wide
subnets are availablility zone wide
AWS reserves 5 ip addresses per subnet

route tables allow from which set of ips we can access which set of ips
each nat is associate with a subnet. nat gives you traffic
nats can be configured manually. we can maintain failover highavailablity for nats.But aws nat takes care of all this work.
if you want it maually then use create your own nat instance.you have to maintain it as per traffic of the subnet 
port forwarding is not supported nat gateway(nat given by aws)

for instances if you want manual routing like in case of manual configuration of NAT instance disable source and destination checks because we are just routing traffic
tyjg
aws tags are used for scripts or automation

you have to configure internet gateway to access internet outside in vpc

amazon light sail ==> basic functionalities no load balancer scaling, easy to setup etc...
elastic bean stalk ==> like heroku
EC2 ==> servers
ECS ==> container service
Lambda ==> to run periodical scripts
batch ==> to run batch jobs
elasticache ==> memcache and redis cache 
cloudfront ==> there are cloudfront servers at various places which have a cache of your website so that the request need not come to your server, supports only get requests
RDS ==> amazon relational database
dynamodb ==> amazon non relational database
amazon redshift ==> dataware house
endpoint ==> access amazon services like s3 within local vpc without going to internet
VPC peering ==> connect multiple vpcs together
virtual private gateway ==> you configure vpn means data is encrypted and sent over internet and on aws side this should be decrypted so configure virtual private gateway 
direct connect ==> your local systems and aws are over private network connection without internet in middle
we can configure vpn service with aws and we have to maintain a small server which encrypts and decrypts data and this data is sent
over internet to aws in encrypted format. so vpns are secure
aws have certifications like pci dss etc.......

cookie based sticky session aws routes based on cookie means based on session. but with this if this instance goes off aws cant restore that session which is in the ram
application load balancer is cost effective but supports only layer7
application load balancers replace multiple classic load balancers. fully integrated with ECS because here we group container groups
whereas in classic load balancer we give individual instances meaning ips of conatiners actually change over time
for ebs volume to have high IOPS add more volume to gp2. gp2 disks are of fixed size and with increase in memory more gp2 disks are made into raid system in aws. 
classic load balancer is region wide
Amazon glacier ==> for longterm sevice less expensive
Amazon s3 ==> costly but used for short term purposes has features like versioning, permissions, time limited access to object, bucket policies
Iam ==> Identity and access management
route53 is amazon dns servers.dns uses port 53 generally so the name route53
if you have same service running across multiple regions say like facebook route 53 can route you to server in another region if the present one is down
r53 offers domains for sale
r53 policies:
single: single dns with multiple ips ips are roundrobined with no health checks 
weighted: above policy but weighted roundrobin
latency: based on the latency. aws maintains history of time taken based on source and destination and based on this history best server is taken
failover: giving alternative ips incase of failover
geolocation: same dns is assciated with different ips and the ip is picked based on geolocation like same dns will serve different content to chinese and japanese 

cloudtrail:
saves history of api calls made to aws

kinesis streams:
kinesis is queing system of amazon 
if data rate increases increase number of shards to absorb more data.to increase shards decrease partitioning size of hash key

SQS:
amazon message queing system.
easy to use
use kinesis if you have very huge data stream
kinesis has advanced features and generally its like map reduce of mongo where as SQS is like kafka

SSL termination:
means offloading the certificate verification or https session maintanace to some other endpoint in aws it is load balancer

IAM rules:
using roles you have temp access
groups and users
policies are permission sets and a group has multiple policies attached to it. each policy can have multiple permissions.

NAT: Network Adress Translation
NAT gives the ip address of source. basically since nat is connected to router it decrypts router adress to get source.

internet gateway aws, configuring private subnets to connect to net using NAT
public vs private subnet aws
why use nat gateways and nat instances. only one of them
different types of instances like spot , bidding , schedulerd
internet osi model
raid implemenmtation

security:
Generally ext. incoming    ext. outgoing     dblayer      internal are zones in security and based on your application restrict access


segmentation segment table virtual memory deepcopy shallow copy base and offset adress
java inputstream reader , bufferedreader working

supervised unsupervised classification and learning naivebayes
costfunctions:
squeared: idealvalue-realvalue)^2/entrycount    gradientdescent==> y=m(x-x1)+y1  m learning rate x-x1 is differential of cost function 
in SGD we take different sets and hence the path goes up and down and may not stay at global min but sure to stay near global with reasonable data

TicTacToe algorithm ==> minmax algorithm

DEVOPS:
RUN unittests, integration tests, performance metrics comparing with the previous ones either timely or with every deployment

adding new tech stack means consider whether it is to be cross coupled with other sources either for analytics or etc..

monitoring is different from logging. for example we use graylog for alerting and imimonitor for monitoring with various integrations

using database with ECS ==> when ram is increased
terraform with ECS and GCP

alerting and logging @ qplum
how qplum is scalable to common people
******************************************************************************
building heap:
building heap takes o(nlogn) time in iterative approach. in this approach we compare at every point whether an element must go down or up since logn is height o(nlogn)
here we start comparing from top and proceed to bottom meaning every bottom element might endup logn times since there are most elements at bottom o(nlogn)

using heapify ==> o(n)
we build heaps from bottom to top so o(n)

heapsort:
build max or min heap and keep deleting an element from top => to build heap(o(n)) for n deletions o(nlgn) ==> total o(n+nlogn) 
***********************************************************************
Rabinkarp algorithm:
https://www.youtube.com/watch?v=H4VrKHVG5qI&t=28s
(a+b)modc = (amodc+bmodc)modc
in rabinkarp algorithm
time complexity o(m+n) incase different patterns dont collide in hashvalue else o(mn)
multiplications are cheaper than divisions
so for abc instead of a+b*p+c*p2 use a*p2+b*p+c so in rolling hash instead of dividing b*p+c*p2 by p multiply b*p+c by p
***********************************************************************
avl tree:
at any point(need not only be root) difference between heights of left and right subtrees < 2
node deletion: https://www.youtube.com/watch?v=cySVml6e_Fc
node insertion: https://www.youtube.com/watch?v=_8qqlVH5NC0 ==> ll,lr,rr,rl applies same way for both terminal as well as non terminal nodes
in both insertion and deletion we start from child to parent for balancing meaning even is some change done at parent tree rooted at chidren will not be affected as it is unchanged
		a
	b		c
    d       e	    f       g
                   h  i    j  k
say rotation is required at c(of course in above example rotation is not required example is taken just to show before and after rotation) to left then left of a remains intact, c becomes root. left of c becomes a, right of c stays same. f moves to right of a with its entire sub tree. This doesnt violates BST property as we are considering the present one is already a binary tree and based on that you can compare new heights in case of rotation for proof. same is the case for right rotation. so end tree is
			c
              a                    g
          b        f
         d e      h i            j    k
*********************************************************************
how to choose tools like rundeck over jenkins over gocd
==> see programming language your team is using. say you have work on java based application better to use jenkins as you can develop plugins easily
==> for deployments see like rundeck can deploy on multiple nodes parallely and we can get status of job logs on each node parallely
==> prefer opensource..jenkins has many plugins over rundeck but gocd has good number of plugins conditions like this
********************************************************
regex matching ==> dynamic programming problem
wildcard pattern matching ==> dynamic programming
in dp problems generally we use last 1 or 2 results to calculate current result meaning no need to have entire dp array in memory ==> memory optimization
*************************************************************************************************************
for linkedlist problems try not to swap pointers as it is difficult maintaining pointers for instance reverse k groups can be acheived by creating a new linked list for every k elements and using addfirst() on new linkedlist and removefirst on main linked list when k elements are completed swap this new linked list as prev+new linked list(to do this you have to maintain tail of prev linkedlist and head of this linkedlist and when you reach tail of this linkedlist you can make this as tail of prev linkedlist and new linkedlist as head)

class Solution {
//    1 2 3 4 5 6 7 8 9 10 11 12 13 14
//    3 2 1 6 5 4 9 8 7 12 11 10 14 13
    public static void main(String args[]){
        int k = 3;
        int adders = 14;
        lllist llf = new lllist();
        for(int i = 1;i < adders+1;i++){
            llf.addlast(new llnode(null,i));
        }

        //groups of k
//        int elements = llf.size-1;
//        lllist prev = null;
//        lllist present = new lllist();
//        llnode temp = llf.removeFirst();
//        present.addfirst(temp);
//        int noelement = 1;
//        while (elements > 0){
//            noelement = noelement+1;
//            temp = llf.removeFirst();
//            if(noelement%k == 1){
//                if(prev == null){
//                    prev = present;
//                }
//                else{
//                    prev.addll(present);
//                }
//                present = new lllist();
//            }
//            present.addfirst(temp);
//            elements = elements - 1;
//        }
//        if(prev == null){
//            prev = present;
//        }
//        else{
//            prev.addll(present);
//        }

        //reversing
        lllist rev = new lllist();
        int ele = llf.size;
        while (ele > 0){
            rev.addfirst(llf.removeFirst());
            ele = ele - 1;
        }
        System.out.println("sss");
    }
}

class llnode{
    llnode next;
    int value;
    llnode(llnode next,int value){
        this.next = next;
        this.value = value;
    }
}

class lllist{
    llnode head;
    llnode tail;
    int size;

    lllist(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void addlast(llnode node){
        if(this.size == 0){
            this.head = node;
            this.size = 1;
            this.tail = node;
        }
        else if(this.size == 1){
            this.head.next = node;
            this.tail = node;
            this.size = 2;
        }
        else{
            this.tail.next = node;
            this.tail = node;
            this.size = this.size+1;
        }
    }

    void addfirst(llnode node){
        if(this.size == 0){
            this.addlast(node);
        }
        else if(this.size == 1){
            this.head = node;
            this.head.next = this.tail;
            this.size = 2;
        }
        else{
            node.next = this.head;
            this.head = node;
            this.size = this.size + 1;
        }
    }

    void addll(lllist ll){
        this.tail.next = ll.head;
        this.tail = ll.tail;
        this.size = this.size+ll.size;
    }

    llnode removeFirst(){
        if(this.size == 0){
            return null;
        }
        else if(this.size == 1){
            llnode hh = this.head;
            this.size = 0;
            this.head = null;
            this.tail = null;
            return hh;
        }
        else{
            llnode tt = this.head;
            this.head = tt.next;
            tt.next = null;
            this.size = this.size-1;
            return tt;
        }
    }
} 
***************************************************************************************************************
given alien language and words were given sorted based on alphabetical order. find out actual ordering of characters.
compare two adjacent words and build alphabet dependency. Atlast we will have individual dependencies and to build dependency tree use topological sort
***************************************************************************************************************
given a string and set of words find whether all these words can be in string continously
a="aforthewoodwood" for,the,wood  ==> all 3 words are in string continuously
a="aforbthecwood" all words are present but not continouus so failed
create a string with all words given k = forthewood and find how many times for is present, the is present and wood is present in k.
now for every continos substringin a the count obtained above must be the same.
****************************************************************************************************************
bcameras:
given a btree and if a node has camera set on it then itself,parent,children will be monitored. minimum no of cameras to monitor all nodes?
==> Greedy problem. traverse from root.
 for each node 
	if not being monitored:
		if no children:
			setcamera
		else:
			setcamera on one of the child whose height is less
			mark the children of node on which camera is set as being monitored
			traverse to children
	if being monitored:
		go to next node
		
*******************************************************
josephus algorithm:
w(n,k) = (w(n-1,k)+k)%n
https://www.youtube.com/watch?v=fZ3p2Iw-O2I
this is state based dp if you know how to reach from state a to state b to state c and so on then use reverse calculation
say n people are there in circle and we have to kill every kth person alive in loop. then the last survivor person index be w(n,k) = (w(n-1,k)+k)%n
***************************************************************************************************************
lru and lfu implementation:
maintain a hashmap with request,response and timestamp. for new request if it is in hashmap then update its timestamp and give response. if not in hashmap iterate over hashmap to get request with least timestamp and remove it and keep new object in map. similarly for lfu but based on frequency instead of timestamps
getfromcache ==> o(1)
getfromdisk ==> o(cachesize)
**********************************************************************************************************************************

**where do you use security in your application?**
In our application, we use security at every place where sensitive or private data travels or gets stored. For example , all customer records, financial data, and any PII (personally identifiable information) protected both while storing ( data-at-rest ) and whilesent between systems ( data-in-transit).

How we use:
We use strong cryptography for all our encryption and decryption operations.
We follow industry standard best practices, mostly using FIPS-complient (Federal Information processing standards) providers like Oracle Security JC ( Java Cryptography) and Bouncy Castle FIPS( bc-fips). t
These providers help us ensure that the encryption algorithms are secure and regulatory -approved.
We never hardcode keys, All keys are securely generated and rotated using a Google KMS Key management service.
For any file or document sent outside efx network, we use PGP encryption with strong key pairs.
What type
Data Encryption ( record level and field level) -
converts sensitive data into unreadable format using algorithms like ASE
Authorised users or services with correct keys can decrypt and read it.
PGP ( Pretty Good Privacy)
Used both public key and private key for safer sharing.
Key Managment:
Securly generating , storing, rotating allcryptographic keys
Access control:
Only authorised users can perform sensitive actions or access secret data.


 we build data protection operations simple and reliable for everyone to adopt across our BU and operations, implementation teams. i built user friendly CLI tools that allow anyone to do encryption, decryption and key managment by running simple commands locally. all the while ensuring they follow compay securoty standards automatically.
everything is built to be easly auditable, quick to automate, adn robust for enterprice needs. this approach reduces securoty riscks and saves time for everyone who has to work with sensitive data.






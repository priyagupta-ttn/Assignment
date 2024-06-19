###### Question 2: How many requests are made when you embed a clientLib which itself has one dependency?

When you embed a clientLib (client library) that itself has one dependency, the number of requests made depends on the nature of how client libraries and their dependencies are managed and loaded.

Here's a breakdown of how this typically works:

Scenario Breakdown
Client Library:
Assume clientLibA is the main client library you are embedding.
clientLibA has one dependency, clientLibB.
Request Flow
Initial Request for clientLibA:

The first request is made to load clientLibA.
Subsequent Request for clientLibB:

Upon loading clientLibA, a subsequent request is made to load its dependency, clientLibB.
Total Requests
First Request: clientLibA
Second Request: clientLibB
Therefore, when you embed clientLibA which has one dependency (clientLibB), a total of 2 requests are made:

One request to load the main client library (clientLibA).
One request to load its dependency (clientLibB).
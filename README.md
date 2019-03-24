# spring-cache-demo
This demo project uses the following technologies
1. SpringBoot
2. EH Cache (For Caching- Uses a simple key and Object. Can extend this to auto evict, store to disk etc)
3. Lombok (To remove boilerplate code)
4. Spring H2 DB (Simple In-Memory DB)
5. Spring Data (Access the DB via CRUD class)

Clone this project and run the Boot class.

Access it via,
http://localhost:8080/products/2
Notice the time taken by the method

Access again http://localhost:8080/products/2
Now notice the time taken by the method.

To view the contents of the cache,
use - http://localhost:8080/cache/viewProductCache

package com.springboot.test;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest {

    public static void main(String[] args){

        Jedis jedis = new Jedis("192.168.1.100",6379);
        /*System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
        jedis.lpush("forezp-list", "Redis");
        jedis.lpush("forezp-list", "Mongodb");
        jedis.lpush("forezp-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("forezp-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }*/
       // jedis.set("name","你爸爸");
        String name = jedis.get("name");
        System.out.println(name);

    }
}

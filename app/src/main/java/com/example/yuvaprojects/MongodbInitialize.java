//package com.example.yuvaprojects;
//
//import org.bson.Document;
//
//import io.realm.Realm;
//import io.realm.mongodb.App;
//import io.realm.mongodb.AppConfiguration;
//import io.realm.mongodb.User;
//import io.realm.mongodb.mongo.MongoClient;
//import io.realm.mongodb.mongo.MongoCollection;
//import io.realm.mongodb.mongo.MongoDatabase;
//
//public class MongodbInitialize {
//    Realm uiThreadRealm;
//    MongoClient mongoClient;
//    MongoDatabase mongoDatabase;
//    MongoCollection<Document> mongoCollection;
//    User user;
//    App app;
//    String AppId = "yuva-demo-tdngt";
//    public void initializeMongoDB(){
//
//        app = new App(new AppConfiguration.Builder(AppId).build());
//        user = app.currentUser();
//        mongoClient = user.getMongoClient("mongodb-atlas");
//        mongoDatabase = mongoClient.getDatabase("YOUR DATABASE NAME");
//        mongoCollection = mongoDatabase.getCollection("YOUR COLLECTION NAME");
//
//    }
//
//}

package com.org.jobs.joblistings.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.org.jobs.joblistings.model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MongoConverter mongoConverter;

    @Override
    public List<Post> findByText(String text) {

        MongoDatabase database = mongoClient.getDatabase("JobSchema");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        List<Post> posts = new ArrayList<>();
        result.forEach(doc -> posts.add(mongoConverter.read(Post.class, doc)));
        return posts;
    }
}

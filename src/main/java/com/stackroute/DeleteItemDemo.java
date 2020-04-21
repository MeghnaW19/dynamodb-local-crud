//package com.stackroute;
//
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
//import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
//import com.amazonaws.services.dynamodbv2.document.DynamoDB;
//import com.amazonaws.services.dynamodbv2.document.Item;
//import com.amazonaws.services.dynamodbv2.document.Table;
//
//import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
//import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
//import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
//import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
//import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
//import com.amazonaws.services.dynamodbv2.model.ReturnValue;
//
//public class DeleteItemDemo {
//
//    static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(
//            new ProfileCredentialsProvider()));
//
//    static String tableName = "UserDetail";
//
//    public static void main(String[] args) {
//        deleteItem();
//    }
//
//    private static void deleteItem() {
//        Table table = dynamoDB.getTable(tableName);
//        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
//                .withPrimaryKey("id", 1);
//        DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
////
////        // Confirm
////        System.out.println("Displaying deleted item...");
////        System.out.println(outcome.getItem().toJSONPretty());
////
//    }
//}

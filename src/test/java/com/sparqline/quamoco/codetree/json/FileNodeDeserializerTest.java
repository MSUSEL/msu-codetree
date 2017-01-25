/**
 * 
 */
package com.sparqline.quamoco.codetree.json;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.sparqline.quamoco.codetree.FileNode;

/**
 * @author fate
 *
 */
public class FileNodeDeserializerTest {

    private FileNodeDeserializer fixture;

    /**
     * @throws Exception
     */
    @Test
    public void testDeserialize_1() throws Exception {
        String json = "{\"methods\": {\"Method\": {\"constructor\": false,\"start\": 50,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#Method\",\"name\": \"Method\"}},\"fields\": {\"TestField\": {\"start\": 25,\"end\": 25,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#TestField\",\"name\": \"TestField\"}},\"start\": 1,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"TEST1\": 1.0},\"qIdentifier\": \"Class\",\"name\": \"Class\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FileNode.class, fixture);
        Gson gson = builder.create();

        FileNode fn = gson.fromJson(json, FileNode.class);
        assertNotNull(fn);
    }

    /**
     * @throws Exception
     */
    @Test(expected = JsonParseException.class)
    public void testDeserialize_2() throws Exception {
        String json = "{\"methods\": {\"Method\": {\"constructor\": false,\"start\": 50,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#Method\",\"name\": \"Method\"}},\"fields\": {\"TestField\": {\"start\": 25,\"end\": 25,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#TestField\",\"name\": \"TestField\"}},\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"TEST1\": 1.0},\"qIdentifier\": \"Class\",\"name\": \"Class\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FileNode.class, fixture);
        Gson gson = builder.create();

        gson.fromJson(json, FileNode.class);
    }

    /**
     * @throws Exception
     */
    @Test(expected = JsonParseException.class)
    public void testDeserialize_3() throws Exception {
        String json = "{\"methods\": {\"Method\": {\"constructor\": false,\"start\": 50,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#Method\",\"name\": \"Method\"}},\"fields\": {\"TestField\": {\"start\": 25,\"end\": 25,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#TestField\",\"name\": \"TestField\"}},\"start\": 1,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"TEST1\": 1.0},\"qIdentifier\": \"Class\",\"name\": \"Class\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FileNode.class, fixture);
        Gson gson = builder.create();

        gson.fromJson(json, FileNode.class);
    }

    /**
     * @throws Exception
     */
    @Test(expected = JsonParseException.class)
    public void testDeserialize_4() throws Exception {
        String json = "{\"methods\": {\"Method\": {\"constructor\": false,\"start\": 50,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#Method\",\"name\": \"Method\"}},\"fields\": {\"TestField\": {\"start\": 25,\"end\": 25,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"Test1\": 1.0},\"qIdentifier\": \"Class#TestField\",\"name\": \"TestField\"}},\"start\": 1,\"end\": 100,\"range\": {\"lowerBound\": {\"endpoint\": 1},\"upperBound\": {\"endpoint\": 1}},\"metrics\": {\"TEST1\": 1.0},\"name\": \"Class\"}";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FileNode.class, fixture);
        Gson gson = builder.create();

        gson.fromJson(json, FileNode.class);
    }

    /**
     * @throws Exception
     */
    @Test(expected = JsonParseException.class)
    public void testDeserialize_5() throws Exception {
        String json = "Test";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(FileNode.class, fixture);
        Gson gson = builder.create();

        gson.fromJson(json, FileNode.class);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Before
    public void setUp() throws Exception {
        fixture = new FileNodeDeserializer();
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @After
    public void tearDown() throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(FileNodeDeserializerTest.class);
    }
}

/*
 * Copyright 2017 The Johns Hopkins University Applied Physics Laboratory LLC
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.jhuapl.dorset.demos;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import edu.jhuapl.dorset.demos.FileManager;

public class FileManagerTest {

    @Test
    public void testAdd() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.addItem("this is an item");
            assertTrue(response.contains("is an item"));

            manager.removeItem("is an item");
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testRemoveByNumGood() {
        try {
            FileManager manager = new FileManager("Nicole");
            String item = manager.getItem(1);
            item = item.substring(item.indexOf("M,") + 2);

            String response = manager.removeItem(1);
            assertTrue(response.contains("1)"));

            manager.addItem(item);
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testRemoveByNumBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.removeItem(20);
            assertTrue(response == null);
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testRemoveByKeywordGood() {
        try {
            FileManager manager = new FileManager("Nicole");
            manager.addItem("item to r by keyword");

            String response = manager.removeItem("item to r");
            assertTrue(response.contains("item to r"));
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testRemoveByKeywordBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.removeItem("non-existent item");
            assertTrue(response == null);
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetAllText() {
        try {
            FileManager manager = new FileManager("Nicole");      

            String response = manager.getAllText().get(0);
            System.out.println(manager.getAllText());
            assertTrue(response.contains("TODO List"));
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetAllItemsWithKeywordGood() {
        try {
            FileManager manager = new FileManager("Nicole");
            manager.addItem("Buy supplies");

            ArrayList<String> response = manager.getAllItemsWithKeyword("Buy");
            assertTrue(response.get(0).contains("Buy"));
            assertFalse(response.get(0).contains("Error"));

            manager.removeItem("Buy supplies");
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetAllItemsWithKeywordBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            ArrayList<String> response = manager.getAllItemsWithKeyword("non-existent items");
            assertTrue(response.isEmpty());
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetAllItemsWithDateGood() {
        try {
            FileManager manager = new FileManager("Nicole");
            manager.addItem("Today's new item");
            String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

            ArrayList<String> response = manager.getAllItemsWithKeyword(date);
            assertTrue(response.get(0).contains(date));

            manager.removeItem("Today's new item");
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetAllItemsWithDateBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            ArrayList<String> response = manager.getAllItemsWithKeyword("July");
            assertTrue(response.isEmpty());
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetItemByNumGood() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.getItem(1);
            assertTrue(response.contains("1),"));
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetItemByNumBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.getItem(20);
            assertTrue(response == null);
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetItemByKeywordGood() {
        try {
            FileManager manager = new FileManager("Nicole");
            manager.addItem("this is a new item");

            String response = manager.getItem("new item");
            assertTrue(response.contains("this is a new item"));

            manager.removeItem("a new item");
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }

    @Test
    public void testGetItemByKeywordBad() {
        try {
            FileManager manager = new FileManager("Nicole");

            String response = manager.getItem("non-existent item");
            assertTrue(response == null);
        } catch (ToDoListAccessException e) {
            assertTrue(false);
        }
    }
}

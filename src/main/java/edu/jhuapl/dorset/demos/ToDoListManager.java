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

import java.util.ArrayList;

public interface ToDoListManager {
    
    public String addItem(String item);
        
    public String removeItem(int itemNumber);
    
    public String removeItem(String itemKeyword);
    
    public ArrayList<String> getAllText();
    
    public ArrayList<String> getAllItemsWithKeyword(String itemKeyword);
    
    public String getItem(int itemNumber);
    
    public String getItem(String itemKeyword);
}

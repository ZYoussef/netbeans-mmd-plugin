/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.nbmindmap.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest {
  
  @Test
  public void testCalcMaxLengthOfBacktickQuotesSubstr() throws Exception {
    assertEquals(0,Utils.calcMaxLengthOfBacktickQuotesSubstr("akldjf lsdkjf"));
    assertEquals(0,Utils.calcMaxLengthOfBacktickQuotesSubstr(null));
    assertEquals(1,Utils.calcMaxLengthOfBacktickQuotesSubstr("akl`djf lsdk`jf"));
    assertEquals(1,Utils.calcMaxLengthOfBacktickQuotesSubstr("akl`djf lsdk`\n`jf"));
    assertEquals(2,Utils.calcMaxLengthOfBacktickQuotesSubstr("akl`djf lsdk``jf"));
    assertEquals(3,Utils.calcMaxLengthOfBacktickQuotesSubstr("akl`djf lsdk``jf```"));
    assertEquals(3,Utils.calcMaxLengthOfBacktickQuotesSubstr("```"));
  }
  
  @Test
  public void testUnescapeStr() {
    assertEquals("Hello\nWorld",Utils.unescapeStr("Hello<br>World"));
    assertEquals("Hello\nWorld",Utils.unescapeStr("Hello< br>World"));
    assertEquals("Hello\nWorld",Utils.unescapeStr("Hello< br  >World"));
    assertEquals("Hello\nWorld",Utils.unescapeStr("Hello< Br  >World"));
    assertEquals("Hello\nWorld",Utils.unescapeStr("Hello< BR  >World"));
  }
}
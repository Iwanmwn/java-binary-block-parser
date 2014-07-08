/* 
 * Copyright 2014 Igor Maznitsa (http://www.igormaznitsa.com).
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
package com.igormaznitsa.jbbp.model;

import com.igormaznitsa.jbbp.compiler.JBBPNamedFieldInfo;
import org.junit.Test;
import static org.junit.Assert.*;

public class JBBPFieldArrayBooleanTest {

  private final JBBPFieldArrayBoolean test = new JBBPFieldArrayBoolean(new JBBPNamedFieldInfo("test.field", "field", 999), new boolean[]{true, false, true, true, false});

  @Test
  public void testNameAndOffset() {
    assertEquals("test.field", test.getFieldPath());
    assertEquals("field", test.getName());
    assertNotNull(test.getNameInfo());
    assertEquals(999, test.getNameInfo().getFieldOffsetInCompiledBlock());
  }

  @Test
  public void testSize() {
    assertEquals(5, test.size());
  }

  @Test
  public void testGetArray() {
    final boolean[] etalon = new boolean[]{true, false, true, true, false};
    final boolean[] array = test.getArray();
    assertEquals(etalon.length, array.length);
    for (int i = 0; i < etalon.length; i++) {
      assertTrue(etalon[i] == array[i]);
    }
  }

  @Test
  public void testGetAsBool() {
    final boolean[] etalon = new boolean[]{true, false, true, true, false};
    for (int i = 0; i < etalon.length; i++) {
      assertEquals(etalon[i], test.getAsBool(i));
    }
  }

  @Test
  public void testGetAsInt() {
    final int[] etalon = new int[]{1, 0, 1, 1, 0};
    for (int i = 0; i < etalon.length; i++) {
      assertEquals(etalon[i], test.getAsInt(i));
    }
  }

  @Test
  public void testGetAsLong() {
    final long[] etalon = new long[]{1L, 0L, 1L, 1L, 0L};
    for (int i = 0; i < etalon.length; i++) {
      assertEquals(etalon[i], test.getAsLong(i));
    }
  }

  @Test
  public void testIterable() {
    final boolean[] etalon = new boolean[]{true, false, true, true, false};
    int index = 0;
    for (final JBBPFieldBoolean f : test) {
      assertTrue(etalon[index++] == f.getAsBool());
    }
  }

}
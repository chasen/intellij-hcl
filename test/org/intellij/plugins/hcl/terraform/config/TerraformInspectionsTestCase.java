/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.plugins.hcl.terraform.config;

import com.intellij.testFramework.InspectionFixtureTestCase;
import org.intellij.plugins.hcl.terraform.config.inspection.HCLUnknownBlockTypeInspection;
import org.intellij.plugins.hil.inspection.HILUnresolvedReferenceInspection;

public class TerraformInspectionsTestCase extends InspectionFixtureTestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    myFixture.setTestDataPath(getBasePath());
  }

  @Override
  protected String getBasePath() {
    return "test-data/terraform/inspections/";
  }

  public void testResourcePropertyReferences() throws Exception {
    doTest("resource_property_reference", new HILUnresolvedReferenceInspection());
  }

  public void testMappingVariableReference() throws Exception {
    doTest("mapping_variable_reference", new HILUnresolvedReferenceInspection());
  }

  public void testKnownBlockNameFromModel() throws Exception {
    doTest("unknown_block_name", new HCLUnknownBlockTypeInspection());
  }

}

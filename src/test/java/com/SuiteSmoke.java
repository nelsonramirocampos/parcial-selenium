package com;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.Tests")
@IncludeTags("Smoke")
public class SuiteSmoke {
}

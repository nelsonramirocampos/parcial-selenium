package com.Suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.Tests")
@IncludeTags("Integration")
public class SuiteIntegration {
}

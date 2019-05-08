package com.example.testing

import com.example.testing.model.ArraysCompareTest
import com.example.testing.model.QuickBeforeAndAfterTest
import com.example.testing.model.StringHelperTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses


@RunWith(Suite::class)
@SuiteClasses(ArraysCompareTest::class, StringHelperTest::class)
class DummyTestSuite
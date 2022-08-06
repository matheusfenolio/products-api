package com.abinbev.productManagement.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UtilTest {
    @InjectMocks
    private Util util;

    @Test
    public void testSumMethod(){
       var result = util.sumTwoIntegerNumbers(1, 2);
        Assert.assertEquals(3, result);
    }
}

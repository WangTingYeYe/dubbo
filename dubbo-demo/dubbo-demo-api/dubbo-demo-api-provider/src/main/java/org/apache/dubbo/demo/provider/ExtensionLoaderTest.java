package org.apache.dubbo.demo.provider;

import com.sun.tools.javac.util.Assert;
import org.apache.dubbo.common.extension.ExtensionFactory;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.extension.factory.AdaptiveExtensionFactory;
import org.apache.dubbo.common.extension.factory.SpiExtensionFactory;
import org.apache.dubbo.common.logger.LoggerAdapter;
import org.apache.dubbo.common.logger.slf4j.Slf4jLoggerAdapter;

/**
 * @author jiadun
 * @date 2020/05/27
 */
public class ExtensionLoaderTest {

    /**
     *
     *slf4j=org.apache.dubbo.common.logger.slf4j.Slf4jLoggerAdapter
     * jcl=org.apache.dubbo.common.logger.jcl.JclLoggerAdapter
     * log4j=org.apache.dubbo.common.logger.log4j.Log4jLoggerAdapter
     * jdk=org.apache.dubbo.common.logger.jdk.JdkLoggerAdapter
     * log4j2=org.apache.dubbo.common.logger.log4j2.Log4j2LoggerAdapter
     *
     * @param args
     */
    public static void main(String[] args) {
        ExtensionLoader<LoggerAdapter> extensionLoader = ExtensionLoader.getExtensionLoader(LoggerAdapter.class);

        // 按照名字取
        LoggerAdapter slf4j = extensionLoader.getExtension("slf4j");
        Assert.check(slf4j instanceof Slf4jLoggerAdapter);

        //获取最合适的一个实现类
        LoggerAdapter adaptiveExtension = extensionLoader.getAdaptiveExtension();
        Assert.check(adaptiveExtension instanceof AdaptiveExtensionFactory);
    }
}

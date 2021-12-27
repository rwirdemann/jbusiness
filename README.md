# JBusiness

JBusiness is a business health monitoring framework inspired by the idea of architectural fitness functions. These functions test and evaluate some primary architectural characteristics of an application. JBusiness takes this idea a step further by providing a framework that let users evaluate primary business KPIs of the system.

For the time being JBusiness distinguishes three kind of _business fitness functions_:

1. Holistic business fitness functions
2. Comparative business fitness functions
3. Atomic business fitness functions

A _holistic business fitness_ function defines one or more KPIs and monitors these KPIs permanently while the system is running in production. A simple example is the amount of money made by an ecommerce shop. The function takes snapshots of this amount every minute and compares the actual value against an expected one. An alert will be raised if the variation between two snapshots exceeds a defined threshold. JBusiness supports this kind of functions by providing a set of classes and interfaces to create simple health monitors:

```
Monitor m = Monitor.builder()
        .windowSize(5)
        .pollingInterval(1000)
        .dataProvider(dataProvider)
        .variationListener(thresholdListener).build();
m.run();
```

## Platform

JBusiness is build in Java but makes no assumption about the underlying execution platform. Thus, fitness functions can be run serverless as AWS Lambda or Azure functions or on every technology platform of your choice.

## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)
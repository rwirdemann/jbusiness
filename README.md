# JBusiness

This repository is the home of the business health monitoring framework _JBusiness_.

## Usage

```
Monitor m = Monitor.builder()
        .windowSize(5)
        .pollingInterval(1000)
        .dataProvider(dataProvider)
        .variationListener(thresholdListener).build();
m.run();
```
## License

* [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)
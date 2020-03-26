# omnom-retail

[![CircleCI](https://circleci.com/gh/nightcrawler-/omnom-retail.svg?style=svg)](https://circleci.com/gh/nightcrawler-/omnom-retail)


### Installation

The instructions below apply to GNU/Linux Distributions, specifically Ubuntu

#### Prerequisites

* Java installed and configured correctly, gradle may be required as well

#### Usage

Download the zip file or clone the repository into a local folder

```
git clone https://github.com/nightcrawler-/omnom-retail.git
cd omnom-retail

```

Download the dependencies by running

```
./gradlew dependencies
```

Run the tests using the following commands

``` 
./gradlew test
```

To generate and view the coverage report, run the commands below

```
./gradlew jacocoTestCoverageVerification

./gradlew jacocoTestReport

xdg-open build/reports/coverage/index.html

```

To build and run the application:

```
./gradlew bootJar

./gradlew bootRun
```

The app is now running on `localhost:8080`

### Sample Request and Response
The API is going to be documented using the OpenAPI specification (Swagger Docs). A standard .yml file describing the API can be generated and published. 
However, the current acceptable request and responses are available below.

To get net payable amounts

```
REQUEST:
    TYPE: GET

http://localhost:8080/net-payable?groceriesAmount=0&totalBillAmount=1000


RESPONSE:

[
  {
    "name": "Employee",
    "net_payable_amount": 650.0
  },
  {
    "name": "Affiliate",
    "net_payable_amount": 850.0
  },
  {
    "name": "User - Recent",
    "net_payable_amount": 950.0
  },
  {
    "name": "User - + 2 years",
    "net_payable_amount": 900.0
  }
]
```
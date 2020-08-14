# spring-security

> Micro projects for spring boot security implementation
> This project is an expirimental implimentation of docker and JWT in Spring Boot Project, Not sutable for production use.

## Table of Contents
- [Installation](#installation)
- [Support](#support)
- [License](#license)

## Installation

### Pre requisites

- [Docker](https://www.docker.com/)
- [Java](https://java.com/en/download/)
- [Maven](https://maven.apache.org/download.cgi)

### Clone

- Clone this repo to your local machine using `https://github.com/jesjesti/spring-security.git`

### Setup

> Build maven project

```shell
$ cd /spring-security/micro-bundle/packager
$ mvn clean install
```

> Start Docker

```shell
$ cd /spring-security/micro-bundle/packager/target/work/dist
$ docker-composer up --build
```

> Run script

```shell
$ cd /spring-security/micro-bundle/packager/target/work
$ sh run_tests.sh
```

## Support

Reach out to me at 

- Email <a id="mailto" href="mailto:jesjesti007@gmail.com" target="_newtab" >`jesjesti007@gmail.com`</a>

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**

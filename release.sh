#!/usr/bin/env bash
rm -rf target/release
mkdir target/release
cd target/release
git clone git@github.com:ceekayel/grails-app-info.git
cd grails-app-info
grails clean
grails compile

#grails publish-plugin --snapshot --stacktrace
grails publish-plugin --stacktrace

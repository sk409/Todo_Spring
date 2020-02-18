FROM openjdk:8-jdk-alpine

RUN apk add nodejs npm

WORKDIR /app

RUN npm i -D webpack webpack-cli vue vue-loader vue-template-compiler vue-style-loader css-loader style-loader babel-loader @babel/core @babel/preset-env sass-loader webpack-livereload-plugin vuetify
RUN npm i axios
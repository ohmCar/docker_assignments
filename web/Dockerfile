#Base Image Reference
FROM node:10

#Specifying work directory
WORKDIR /usr/src/webapp

#COPY dependency configuration file
COPY package*.json ./

#Setting dependencies
RUN npm install

#Copying app

COPY . .

EXPOSE 3000

CMD [ "npm", "start" ]
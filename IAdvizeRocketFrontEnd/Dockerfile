FROM node:14-alpine

EXPOSE 80

WORKDIR /app

COPY package.json ./
COPY yarn.lock ./

RUN yarn install

COPY . ./

# start app
CMD ["npm", "start"]

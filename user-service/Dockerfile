FROM  --platform=linux/amd64 node:18
WORKDIR /app
COPY package*.json ./
ENV NODE_ENV "production"
RUN npm install
COPY . .
EXPOSE 3000
CMD [ "npm", "start" ]

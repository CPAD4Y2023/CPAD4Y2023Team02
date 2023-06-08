FROM --platform=linux/amd64 node:16-slim
WORKDIR /approuter
COPY . .
ENV NODE_ENV "production"
RUN npm install
EXPOSE 5000
CMD ["npm", "start"]
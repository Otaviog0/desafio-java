FROM gradle:7.6 as builder
RUN mkdir /app
WORKDIR /app
COPY . .
RUN gradle war
RUN mv ./build/libs/*.war root.war
FROM jetty as runtime
COPY --from=builder /app/root.war /var/lib/jetty/webapps/root.war
# pdf-generation-service

This is a service that creates pdf for its customers: this system collects info form customers generates pdf and emails it back to them using RabbitMQ as a message broker.
The part of generating pdf is taken care by the rabbit mq which results in good decoupling between the task producer (the web controller) and the consumers (the remote workers).
The consumers accepts the pdf from the queue and processes the pdf and at the same the producer is able to queue up new messages to rabbit mq.



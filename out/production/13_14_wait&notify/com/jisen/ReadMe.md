如果程序中有两个线程,即消费者和生产者,那么生产者可以通知消费者,让消费者开始消耗数据,
因为队列缓冲区有内容待消耗(不为空).相应的,消费者可以通知生产者产生更多的数据,因为当它消耗掉某些数据后缓冲区不再为满
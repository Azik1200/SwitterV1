CREATE TABLE user_subscription(
    channel_id int not null references usr,
    subscriber_id int not null references usr,
    primary key (channel_id, subscriber_id)
    )
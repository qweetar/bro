package ru.myfirstwebsite.bro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myfirstwebsite.bro.domain.User;
import ru.myfirstwebsite.bro.domain.UserSubscription;
import ru.myfirstwebsite.bro.domain.UserSubscriptionId;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);

    List<UserSubscription> findByChannel(User channel);

    UserSubscription findByChannelAndSubscriber(User channel, User subscriber);
}

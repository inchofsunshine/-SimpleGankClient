package  com.alu.sg.alugank.present

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by Alu on 2017/6/13.
 * 版本：V1.0
 */
open class BasePresenter{
    var compositeSubscription = CompositeSubscription()
    protected fun addSubscription(subscription: Subscription){
        compositeSubscription.add(subscription)
    }
    fun unSubscription(){
        if(compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe()
        }
    }
}


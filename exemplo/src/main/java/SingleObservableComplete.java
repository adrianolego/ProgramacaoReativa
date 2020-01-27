import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SingleObservableComplete {

    void singleObservableComplete() throws InterruptedException {
        Disposable disposable = Completable.complete()
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onStart() {
                        System.out.println("Observable complete started");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Observable complete done");
                    }
                });
        Thread.sleep(3000);
        //start observing
        disposable.dispose();
    }
}


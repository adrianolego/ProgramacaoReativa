import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SingleObservable {

    void singleObservable() throws InterruptedException {

        Single<String> testeSigle = Single.just("Observable");

        //Criando observador
        Disposable disposable = testeSigle.delay(2, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableSingleObserver<String>() {

            @Override
            public void onSuccess(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        Thread.sleep(3000);
        //Comecando observacao
        disposable.dispose();
    }
}

import io.reactivex.Maybe;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SingleObservableMaybe {
    void singleObservableMaybe() throws InterruptedException {

        Maybe<String> testeSigleMaybe = Maybe.just("Observable Maybe");

        //Criando observador
        Disposable disposable = testeSigleMaybe.delay(2, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableMaybeObserver<String>() {

            @Override
            public void onSuccess(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        });
        Thread.sleep(3000);
        //Comecando observacao
        disposable.dispose();
    }
}

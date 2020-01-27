public class Demo {
    public static void main(String[] args) throws InterruptedException {
//        List<Integer> dados = Arrays.asList(1, 2, 3, 3, 4, 5,6,7,8,9,10,11,12,13,14,15);
//        System.out.println(dados.toString());
//        EventSource eventSource = new EventSource();

//        Flux.just("Hello World!").subscribe(System.out::println);

//        dados.parallelStream().filter(item -> item <= 3).collect(Collectors.toList()).forEach(item -> System.out.println(item));
//        dados.parallelStream().filter(item -> item > 3).collect(Collectors.toList()).forEach(item -> System.err.println(item));

//        dados.parallelStream().forEach(item -> {
//            if(item > 3){
//                System.out.println("red "+item);
//            }else {
//                System.out.println(item);
//            }
//        });
//
//        System.out.println("final");


//        dados.stream().forEach(item -> {
//            if(item > 3){
//                System.out.println("red "+item);
//            }else {
//                System.out.println(item);
//            }
//        });

//        System.out.println(dados.stream().filter(item -> item <= 3).collect(Collectors.toList()));;

//        eventSource.addObserver1(event -> {
//            System.out.println("Resposta recebida 1: " + event.stream().filter(dado -> dado <=3));
//        });
//
//        eventSource.addObserver2(event -> {
//            System.out.println("Resposta recebida 2: " + event.stream().filter(dado -> dado <3).toString());
//        });
////        eventSource.scanSystemIn();
//        eventSource.quebraArray(dados);

        //Testes com Observables
        SingleObservable single = new SingleObservable();
        single.singleObservable();

        SingleObservableMaybe singleMaybe = new SingleObservableMaybe();
        singleMaybe.singleObservableMaybe();

        SingleObservableComplete singleComplete = new SingleObservableComplete();
        singleComplete.singleObservableComplete();
    }
}

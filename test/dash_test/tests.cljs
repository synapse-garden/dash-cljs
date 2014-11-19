(ns dash-test.tests)

(def tests
  '({:should "add two and two to get four"
     :fn (fn [] (= (+ 2 2) 4))}

    {:should "get a name from a map"
     :fn (fn [names] (= (:bob names) "Bob Anderson"))
     :args {:bob "Bob Anderson" :jim "Slim Jim"}}))

(ns clj.problem2
  (:gen-class))

(def problem 2)
(def description "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.")

(defn fib
  [x y]
  (lazy-seq (cons x (fib y (+ y x)))))

(defn -main
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (apply +
      (take-while
        #(< % 4000000)
        (filter even? (fib 1 1))))))

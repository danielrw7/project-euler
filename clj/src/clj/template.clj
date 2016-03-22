(ns clj.problemN
  (:gen-class))

(def problem -1)
(def description "")

(defn -main
  [& args]
  (println
    "Problem" (str problem ":") description "\n"
    "Solution:\n"
    (solution-goes-here)))

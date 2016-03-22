(ns clj.core
  (:gen-class))

(def filePrefix "problem")
(defn moduleFileName [n] (str "clj/" filePrefix n))
(defn moduleName [n] (str "clj." filePrefix n))
(defn fileName [n] (str "src/clj/" filePrefix n ".clj"))

(defn existingProblems
  []
  (take-while
    #(.exists (clojure.java.io/as-file (fileName %)))
    (iterate inc 1)))

(defn loadAndInit
  "Loads a problem file by n"
  [& args]
  (doseq
    [n args]
    (load (moduleFileName n))
    (apply
      (ns-resolve
        (symbol (moduleName n))
        (symbol "-main"))
      [])))

(defn -main
  ([]       (apply loadAndInit (existingProblems)))
  ([& args] (apply loadAndInit args)))

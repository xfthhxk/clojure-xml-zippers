(ns so
  (:require [clojure.data.xml :as x]
            [clojure.data.zip.xml :as z]
            [clojure.zip :as zip]
            [clojure.java.io :as io]))

(defn parse
  [file]
  (letfn [(parse-detail [z]
            {:next-status     (Integer/parseInt (z/xml1-> z :szNextStatus z/text))
             :line-number     (Double/parseDouble (z/xml1-> z :mnOrderLineNumber z/text))
             :amount-received (Integer/parseInt (z/xml1-> z :mnAmountReceived z/text))})]
    (with-open [r (io/reader file)]
      (let [zipper (->> r x/parse zip/xml-zip)]
        (z/xml-> zipper :svResponse :event :body :detail_D1 parse-detail)))))

(defn -main
  [& args]
  (println "All parsed data:")
  (println (parse "input.xml"))
  (println "")
  (println "Filtered data:")
  (println (filter (comp #{1.0} :line-number) (parse "input.xml"))))

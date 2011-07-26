(defproject july-clojure-dojo "1.0.0-SNAPSHOT"
  :description "Team 5 event brite replacement"
  :dependencies [[ org.clojure/clojure "1.2.1"]
                 [ org.clojure/clojure-contrib "1.2.0"]
                 [ ring/ring-jetty-adapter "0.3.10" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                 [ compojure "0.6.4" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                 [ enlive "1.0.0"]]
  :dev-dependencies [[lein-ring "0.4.5"]]
  :ring {:handler july-clojure-dojo.core/app })

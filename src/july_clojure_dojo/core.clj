(ns july-clojure-dojo.core  
  (:use compojure.core)
  (:require [compojure.route :as route])
  (:require [compojure.handler :as handler])
  (:require [net.cgrand.enlive-html :as html]))

(html/deftemplate
  layout
  "july_clojure_dojo/layout.html"
  [] )

(html/deftemplate
  layout-two
  "july_clojure_dojo/layout.html"
  [message]
  [:#content]
  (html/content message))

(defn form-page [] (layout))

(defn load []
  (read-string (slurp "/tmp/registration"))
  )

(defn save [data]
  (spit "/tmp/registration" (pr-str data)))

(defn register [fullname]
  (save (conj (load) fullname))
  (layout-two  (str fullname "You are now registered"))
  )

(defroutes event-wane
  (GET "/" [] (form-page))
  (POST "/register" [fullname] (register fullname))
  (GET "/admin" [] (layout-two (pr-str (load)))))

(def app
  (handler/site event-wane))

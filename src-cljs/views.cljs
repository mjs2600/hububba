(ns hububba.views
  (:require [enfocus.core :as ef]
            [enfocus.events :as events]
            [enfocus.effects :as effects])
  (:require-macros [enfocus.macros :as em]))

(defn add-post [post]
  (ef/at js/document
         ["ul"] (ef/prepend (ef/html [:li post]))))

(defn add-posts [posts]
  (doseq [post posts] (add-post post)))

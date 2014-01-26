(ns hububba.posts
  (:require [ajax.core :refer [ajax-request
                               raw-response-format
                               url-request-format
                               edn-format
                               codec]]
            [hububba.views :as views]))

(defn render-posts [[ok content]]
  (.log js/console content)
  (views/add-posts content))

(defn all-posts []
  (.log js/console "Getting posts")
  (ajax-request "/posts" :get {:handler render-posts
                               :format (edn-format)}))

(defn create-post [post]
  (ajax-request "/posts" :post {:params post
                                :handler render-posts
                                :format (edn-format)}))

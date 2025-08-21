#!/usr/bin/env nu
# ./lib/validate.nu
use std/log


# Function to validate the presence of the CONVENIA_API_TOKEN environment variable
def call-api [path: string query?: string] {
    let url = build-url $path $query
    exec-url $url
}

def get-token [] {
  if ("CONVENIA_API_TOKEN" in $env) {
    $env.CONVENIA_API_TOKEN
  } else {
    log error "CONVENIA_API_TOKEN not set"
  }
}

def exec-url [url: string] {

    # Validate token and retrieve it
    let token = get-token
    let invalid =  $token | is-empty

    if not $invalid {
        log info ( $url )
        # Construct the full URL
        # Fetch the list of employees using the validated token
        http get $url --headers { token: $token } | get data
    }

}

# Define a function that constructs a URL from a path and optional query string
def build-url [path: string, query?: string] {
  let base = "https://public-api.convenia.com.br/api/v3"
  # Construct the base URL with the provided path
  let url = $base + $path

  # If a non-empty query is provided, append it properly to the URL
  if ($query != null and $query != "") {
    if ($query | str starts-with "?") {
      $url + $query
    } else {
      $url + "?" + $query
    }
  } else {
    $url
  }
}



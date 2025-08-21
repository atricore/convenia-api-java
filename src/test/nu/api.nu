#!/usr/bin/env nu

def to-path [path?: string] {
    if ($path | is-empty) {
        ""
    } else {
        if ($path | str starts-with "/") { $path } else { "/" + $path }
    }

}

# Entity:
# - employees
# - employees/dismissal
#
def main [
    entity?: string
    id?: string
    data?: string
    --query = ""
    ] {

    # Source the validation library
    source ./lib/utils.nu

    # Prepare the path segment: if provided, ensure it starts with '/'
    let vPath = to-path $entity
    let vId = to-path $id
    let vPath2 = to-path $data

    let q = if ($query | is-not-empty) { "?" + $query } else { "" }

    let fullpath = $vPath + $vId + $vPath2 + $q
    call-api $fullpath | to json

}
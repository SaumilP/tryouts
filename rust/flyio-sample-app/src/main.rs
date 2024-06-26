#![deny(warnings)]
use warp::Filter;

#[tokio::main]
async fn main() {
    let routes = warp::any().map(|| "Heya!");
    warp::serve(routes)
        .run(([0, 0, 0, 0, 0, 0, 0, 0], 8080))
        .await;
}

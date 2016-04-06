
@RestController
class HelloworldController {
  @RequestMapping("/hello/{name}")
  def hello(@PathVariable name)
  {
    [greeting: "Hello "+ name]
  }
}

package goober.hi


class Spike {
  import goober.hi.route53.model._

  for {
    y ← route53.associateVPCWithHostedZone(
      hostedZoneId = "Z2DMROSCVI3J5R",
      vpc          = vpc(
        region = "eu-west-2",
        id = "vpc-042987a2360bb2f8a"
      )
    )
  } yield "your mum'"
}

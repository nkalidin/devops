terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.0"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  region = "eu-west-3"
}


resource "aws_vpc" "trainer1" {
  cidr_block       = "100.0.0.0/16"
  instance_tenancy = "default"

  tags = {
    Name = "main"
  }
}

resource "aws_ebs_volume" "trainer1" {
  availability_zone = "eu-west-3a"
  size              = 3

  tags = {
    Name = "trainer-volume"

  }
}

resource "aws_security_group" "trainer-all" {
  name        = "trainer-all"
  description = "Allow all inbound traffic"
  vpc_id      = aws_vpc.trainer1.id

  ingress {
    description = "TLS from VPC"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = [aws_vpc.trainer1.cidr_block]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "allow_all"
  }
}

resource "aws_ecs_cluster" "trainer1" {
  name = "trainer1"

  setting {
    name  = "containerInsights"
    value = "enabled"
  }
}
resource "aws_iam_group" "trainer1" {
  name = "trainer1"
}

resource "aws_iam_group_policy" "trainer1_policy1" {
  name  = "trainer1_policy1"
  group = aws_iam_group.trainer1.name

  # Terraform's "jsonencode" function converts a
  # Terraform expression result to valid JSON syntax.
  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action = [
          "ec2:Describe*",
        ]
        Effect   = "Allow"
        Resource = "*"
      },
    ]
  })
}

resource "aws_iam_user" "trainer1" {
  name = "trainer1"
  tags = {
    Name = "trainer1"
  }
}

resource "aws_iam_user_group_membership" "trainer-assigmnet" {
  user = aws_iam_user.trainer1.name

  groups = [
    aws_iam_group.trainer1.name,
  ]
}
